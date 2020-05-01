package com.fiscord.litmus.registration.controller;

import com.fiscord.litmus.common.model.OAuthProvidedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiscord.litmus.common.model.User;
import com.fiscord.litmus.messaging.service.api.UserManagementService;

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String addUser(@RequestBody User user) {
		try {
		userManagementService.addUser(user);
		return "Success";
		}catch(Exception e) {
			return "{'Failed' : 'true'}";
		}
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public OAuthProvidedUser getUser(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient, @AuthenticationPrincipal OAuth2User oAuth2User) {

        return new OAuthProvidedUser(oAuth2User.getName(), authorizedClient.getClientRegistration().getClientName(), oAuth2User.getAttributes().toString());

}

}
