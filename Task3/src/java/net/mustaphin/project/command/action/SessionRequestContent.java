/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class SessionRequestContent {

    private HashMap<String, Object> requestAttributes;
    private HashMap<String, String[]> requestParameters;
    private HashMap<String, Object> sessionAttributes;

    public SessionRequestContent() {
	this.requestAttributes = new HashMap<>();
	this.requestParameters = new HashMap<>();
	this.sessionAttributes = new HashMap<>();
    }

    public void extractValues(HttpServletRequest request) {
	Enumeration<String> names = request.getAttributeNames();
	while (names.hasMoreElements()) {
	    String name = names.nextElement();
	    this.requestAttributes.put(name, request.getAttribute(name));
	}
	names = request.getParameterNames();
	while (names.hasMoreElements()) {
	    String name = names.nextElement();
	    this.requestParameters.put(name, request.getParameterValues(name));
	}
	names = request.getSession().getAttributeNames();
	while (names.hasMoreElements()) {
	    String name = names.nextElement();
	    this.sessionAttributes.put(name, request.getSession().getAttribute(name));
	}
    }

    public void insertAttributes(HttpServletRequest request) {
	for (Map.Entry<String, Object> attribute : requestAttributes.entrySet()) {
	    request.setAttribute(attribute.getKey(), attribute.getValue());
	}
	for (Map.Entry<String, Object> attribute : sessionAttributes.entrySet()) {
	    request.getSession().setAttribute(attribute.getKey(), attribute.getValue());
	}
    }

    public HashMap<String, Object> getRequestAttributes() {
	return new HashMap<>(requestAttributes);
    }

    public HashMap<String, String[]> getRequestParameters() {
	return requestParameters;
    }

    public HashMap<String, Object> getSessionAttributes() {
	return new HashMap<>(sessionAttributes);
    }

}
