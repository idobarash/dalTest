package com.cooladata.dal.application.temp;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PublicJsonMessageConverter extends MappingJackson2JsonView {

	@Override
	public void setObjectMapper(ObjectMapper objectMapper) {
		// TODO Auto-generated method stub
		super.setObjectMapper(objectMapper);
	}

	@Override
	public void setEncoding(JsonEncoding encoding) {
		// TODO Auto-generated method stub
		super.setEncoding(encoding);
	}

	@Override
	public void setJsonPrefix(String jsonPrefix) {
		// TODO Auto-generated method stub
		super.setJsonPrefix(jsonPrefix);
	}

	@Override
	public void setPrefixJson(boolean prefixJson) {
		// TODO Auto-generated method stub
		super.setPrefixJson(prefixJson);
	}

	@Override
	public void setPrettyPrint(boolean prettyPrint) {
		// TODO Auto-generated method stub
		super.setPrettyPrint(prettyPrint);
	}

	@Override
	public void setModelKey(String modelKey) {
		// TODO Auto-generated method stub
		super.setModelKey(modelKey);
	}

	@Override
	public void setModelKeys(Set<String> modelKeys) {
		// TODO Auto-generated method stub
		super.setModelKeys(modelKeys);
	}

	@Override
	public void setRenderedAttributes(Set<String> renderedAttributes) {
		// TODO Auto-generated method stub
		super.setRenderedAttributes(renderedAttributes);
	}

	@Override
	public void setExtractValueFromSingleKeyModel(
			boolean extractValueFromSingleKeyModel) {
		// TODO Auto-generated method stub
		super.setExtractValueFromSingleKeyModel(extractValueFromSingleKeyModel);
	}

	@Override
	public void setDisableCaching(boolean disableCaching) {
		// TODO Auto-generated method stub
		super.setDisableCaching(disableCaching);
	}

	@Override
	public void setUpdateContentLength(boolean updateContentLength) {
		// TODO Auto-generated method stub
		super.setUpdateContentLength(updateContentLength);
	}

	@Override
	protected void prepareResponse(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		super.prepareResponse(request, response);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		super.renderMergedOutputModel(model, request, response);
	}

	@Override
	protected Object filterModel(Map<String, Object> model) {
		// TODO Auto-generated method stub
		return super.filterModel(model);
	}

	@Override
	protected void writeContent(OutputStream stream, Object value,
			String jsonPrefix) throws IOException {
		// TODO Auto-generated method stub
		super.writeContent(stream, value, jsonPrefix);
	}


}
