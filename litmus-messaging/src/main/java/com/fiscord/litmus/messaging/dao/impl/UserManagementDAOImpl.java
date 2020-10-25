package com.fiscord.litmus.messaging.dao.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscord.litmus.common.model.User;
import com.fiscord.litmus.firebase.service.api.FirebaseService;
import com.fiscord.litmus.messaging.dao.api.UserManagementDAO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class UserManagementDAOImpl implements UserManagementDAO{

	@Autowired
	private FirebaseService firebaseService;
	
	@Override
	public User addUser(User user) {
		System.out.println("Adding User to Firebase CLoud databases");
		Firestore firestoreDB = firebaseService.getFirestoreDB();
		ApiFuture<WriteResult> collectionsApiFuture = firestoreDB.collection("users").document(user.getUserId()).set(user);
		return user;
	}

	@Override
	public User getUserByUsername(String userName) {
		System.out.println("Getting User by Username");
		Firestore firestoreDB = firebaseService.getFirestoreDB();
		ApiFuture<QuerySnapshot> future = firestoreDB.collection("users").whereEqualTo("userName",userName).get();
		User user=null;
		try {
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			if(!documents.isEmpty()) {
				user = documents.get(0).toObject(User.class);
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Connection to firebase is failed.");
			e.printStackTrace();
		}
		System.out.println("Returning User."+user.getUserName());
		return user;
	}

	@Override
	public User getUserByUserId(String userId) {
		System.out.println("Getting User by userId");
		Firestore firestoreDB = firebaseService.getFirestoreDB();
		User user=null;
		try {
			DocumentReference docRef = firestoreDB.collection("users").document(userId);
			ApiFuture<DocumentSnapshot> future = docRef.get();
			DocumentSnapshot document = future.get();
			if (document.exists()) {
				user = document.toObject(User.class);
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Connection to firebase is failed.");
		}
		return user;
	}

	@Override
	public String getUserPassword(String userId) {
		System.out.println("Getting password for user:"+userId);
		Firestore firestoreDB = firebaseService.getFirestoreDB();
		String password=null;
		try {
			DocumentReference docRef = firestoreDB.collection("users").document(userId);
			ApiFuture<DocumentSnapshot> future = docRef.get();
			DocumentSnapshot document = future.get();
			if (document.exists()) {
				password=document.getString("password");
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("User not found");
		}
		System.out.println("Returing password");
		return password;
	}
	

}
