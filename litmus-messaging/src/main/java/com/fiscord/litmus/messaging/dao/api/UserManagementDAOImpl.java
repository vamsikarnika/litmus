package com.fiscord.litmus.messaging.dao.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiscord.litmus.common.model.User;
import com.fiscord.litmus.firebase.service.api.FirebaseService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
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

}
