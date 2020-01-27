package com.heb.demo.hebgiphy.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class AuthenticationService {

    private String verify(String idToken) {
        try {
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            return decodedToken.getUid();
        } catch (FirebaseAuthException e) {
            return null;
        }
    }

    private DocumentReference getVerifiedDocument(String idToken) {
        String userToken = verify(idToken);
        Firestore db = FirestoreClient.getFirestore();
        return db.collection("favorites").document(userToken);
    }


    public boolean save(String idToken, String giphyId) {
//        String userToken = verify(idToken);
//        Firestore db = FirestoreClient.getFirestore();
//        DocumentReference documentReference = db.collection("favorites").document(userToken);
        DocumentReference documentReference = this.getVerifiedDocument(idToken);

        Map<String, Object> docData = new HashMap<>();
        docData.put("list", FieldValue.arrayUnion(giphyId));

        ApiFuture<WriteResult> arrayUnion = documentReference.set(docData, SetOptions.merge());

        try {
            System.out.println("Write Results: " + arrayUnion.get());
            return true;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean remove(String idToken, String giphyId) {
//        String userToken = verify(idToken);
//        Firestore db = FirestoreClient.getFirestore();
//        DocumentReference documentReference = db.collection("favorites").document(userToken);
        DocumentReference documentReference = this.getVerifiedDocument(idToken);

        ApiFuture<WriteResult> arrayUnion = documentReference
                .update("list", FieldValue.arrayRemove(giphyId));
        try {
            System.out.println("Write Results: " + arrayUnion.get());
            return true;
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
            return false;
        }
//        Map<String, Object> docData = new HashMap<>();
//        docData.put("list", FieldValue.arrayUnion(giphyId));
//        ApiFuture<WriteResult> arrayUnion = documentReference.set(docData, SetOptions.merge());
//        ApiFuture<WriteResult> arrayUnion = washingtonRef.update("regions",
//                FieldValue.arrayUnion("greater_virginia"));
    }

    public List<String> getAll(String idToken) {
//        String userToken = verify(idToken);
//        Firestore db = FirestoreClient.getFirestore();
//        DocumentReference documentReference = db.collection("favorites").document(userToken);
        DocumentReference documentReference = this.getVerifiedDocument(idToken);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        try {
            Map<String, Object> data = future.get().getData();
            return (List<String>) data.values().iterator().next();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//    public void save() {
//        Firestore db = FirestoreClient.getFirestore();
//        DocumentReference docRef  = db.collection("favorites").document("");
//        Map<String, Object> data = new HashMap<>();
//        data.put("first", "Ada");
//        data.put("last", "Lovelace");
//        data.put("born", 1815);
//        //asynchronously write data
//        ApiFuture<WriteResult> result = docRef.set(data);
//        // ...
//        // result.get() blocks on response
//        try {
//            System.out.println("Update time : " + result.get().getUpdateTime());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }


//        ArrayList<Object> list = new ArrayList<>();
//        list.add(giphyId);
//        list.add("sefasdf");
//        Map<String, Object> docData = new HashMap<>();
//        docData.put("favorites", list);
//        ApiFuture<WriteResult> result = documentReference.set(docData);
//
//
//        DocumentReference washingtonRef = db.collection("cities").document("DC");
//
//// Atomically add a new region to the "regions" array field.
//        ApiFuture<WriteResult> arrayUnion = washingtonRef.update("regions",
//                FieldValue.arrayUnion("greater_virginia"));
//        System.out.println("Update time : " + arrayUnion.get());
//
//// Atomically remove a region from the "regions" array field.
//        ApiFuture<WriteResult> arrayRm = washingtonRef.update("regions",
//                FieldValue.arrayRemove("east_coast"));
//        System.out.println("Update time : " + arrayRm.get());