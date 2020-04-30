package com.fiscord.litmus.litmus_messaging.firebase.authentication;

import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@Service
public class FirebaseSDKAuthentication {

	@PostConstruct
	public void initiliaze() {
		try {
			System.out.println("Initializing Firebase");

            InputStream serviceAccount = new ClassPathResource("config/firebase/litmus-1b878-firebase-adminsdk.json").getInputStream();

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://litmus-1b878.firebaseio.com").build();

			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Exception in Initializing Firebase App");
			e.printStackTrace();
		}
		System.out.println("Firebase Initialized");
	}


}
