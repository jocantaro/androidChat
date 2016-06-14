package jako.jocantaro.android.androidchat.domain;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import jako.jocantaro.android.androidchat.entities.User;

public class FirebaseHelper {

    //variable con la referencia al repositorio
    private Firebase dataReference;

    //para el respositorio tenemos una URL.
    private final static String FIREBASE_URL = "https://jocantarochat.firebaseio.com";

    //Otra constante para las rutas en el repositorio de Firebase
    private final static String CHATS_PATH = "chats";
    private final static String USERS_PATH = "users";
    private final static String CONTACTS_PATH = "contacts";

    //los chats van a requerir de un separador entre los usuarios
    private final static String SEPARATOR = "___";

    //inicializamos el singleton
    private static class SingletonHolder{
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance (){
        return SingletonHolder.INSTANCE;
    }

    //el constructor inicia datareference
    public FirebaseHelper (){
        this.dataReference = new Firebase (FIREBASE_URL);
    }


    public Firebase getDataReference(){
        return dataReference;
    }


    //devuelve el correo del usuario autentificado
    public String getAuthUserEmail(){
        AuthData authData = dataReference.getAuth();

        String email = null;

        if  (authData != null) {

            Map<String,Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();

        }
        return email;

    }

    //devuelve la referencia a los usuarios a partir del email
    public Firebase getUserReference (String email) {
        Firebase userReference = null;
        if (email != null){
            //firebase no permite puntos, por eso reemplazamos el del email por un guión bajo
            String emailkey = email.replace(".","_");
            userReference = dataReference.getRoot().child(USERS_PATH).child(emailkey);
        }
        return userReference;
    }

    public Firebase getContactsReference(String email) {
        return getUserReference(email).child (CONTACTS_PATH);
    }

    //devuelve la referencia del usuario autentificado
    public Firebase getMyUserReference (){
        return getUserReference(getAuthUserEmail());
    }


    //obtener mis contactos
    public Firebase getMyContactsReference(){
        return getContactsReference(getAuthUserEmail());
    }


    //obtener contactos de un usuario
    public Firebase getOneContacReference (String mainEmail, String childEmail){
        String childkey = childEmail.replace(".","_");
        return getUserReference(mainEmail).child(CONTACTS_PATH).child(childkey);
    }


    //la referencia para los chats es más compleja, porque hace falta un seperador.
    // Y además hay que comparar para tenerlo por orden alfabético
    public Firebase getChatReference (String receiver) {
        String keySender = getAuthUserEmail().replace(".","_");
        String keyReceiver = receiver.replace(".","_");

        String keyChat = keySender + SEPARATOR + keyReceiver;
        if (keySender.compareTo(keyReceiver) > 0) {
            keyChat = keyReceiver + SEPARATOR + keySender;
        }

        return dataReference.getRoot().child(CHATS_PATH).child(keyChat);
    }

    //cambiar estatus de conexión de un usuario
    public void changedUserConnectionStatus (boolean online) {
        if (getMyUserReference() != null) {
            Map<String,Object> updates = new HashMap<String,Object>();
            updates.put("online",online);
            getMyUserReference().updateChildren(updates);
            
            //pero al cambiar el estatus hay que comunicar a los contactos
            notifyContactsOfConnectionChange (online);
        }
    }

    public void notifyContactsOfConnectionChange(boolean online) {
        notifyContacsOfConnectionChange (online, User.OFFLINE);
    }

    public void signOff () {
        notifyContacsOfConnectionChange(User.OFFLINE,true);
    }

    private void notifyContacsOfConnectionChange(final boolean online, final boolean signoff) {
        final String myEmail = getAuthUserEmail();
        getMyContactsReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren() ){
                    String email = child.getKey();

                    //enviamos el email del usuario que est'a en mis contactos, y mi correo, as'i aviso a mis contactos de que estoy offline
                    Firebase reference = getOneContacReference(email,myEmail);
                    reference.setValue(online);


                }
                //si cierro sesi'on, despu'es de avisar a todos hacemos esto. No podemos hacerlo antes, porque entonces no podr'iamos notificarlo
                if (signoff) {
                    dataReference.unauth();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });

    }


}
