package co.edu.uco.nose.controller.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public final class Response<T> {
	
	private List<String> messages;
	private List<T> data;
	private boolean responseSucceded;
	

	
	public Response(final List<String> messages, final List<T> data, 
			final boolean responseSucceded) {
		setMessages(messages);
		setData(data);
		setResponseSucceded(responseSucceded);
	}
	
	public static <T> Response<T> createSuccededResponse() {
		return new Response<>(new ArrayList<String>(), new ArrayList<>(), true);
	}
	
	public static <T> Response<T> createFailedResponse() {
		return new Response<>(new ArrayList<String>(), new ArrayList<>(), false);
	}
	
	public static <T> Response<T> createSuccededResponse(final List<T> data) {
		return new Response<>(new ArrayList<String>(), data, true);
	}
	
	public static <T> Response<T> createFailedResponse(final List<T> data) {
		return new Response<>(new ArrayList<String>(), data, false);
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(final List<String> messages) {
		this.messages = ObjectHelper.getDefault(messages, new ArrayList<String>());
	}
	
	public void addMessage(final String message) {
		if (!TextHelper.isEmptyWithTrim(message)) {
			getMessages().add(message);
		}
	
	}

	public List<T> getData() {
		return data;
	}

	public void setData(final List<T> data) {
		this.data = ObjectHelper.getDefault(data, new ArrayList<T>());
	}

	public boolean isResponseSucceded() {
		return responseSucceded;
	}

	public void setResponseSucceded(final boolean responseSucceded) {
		this.responseSucceded = responseSucceded;
	}
	
	
}
