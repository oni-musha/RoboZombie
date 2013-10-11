package com.lonepulse.robozombie.processor;

/*
 * #%L
 * RoboZombie`
 * %%
 * Copyright (C) 2013 Lonepulse
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.lonepulse.robozombie.annotation.Asynchronous;
import com.lonepulse.robozombie.annotation.Endpoint;
import com.lonepulse.robozombie.annotation.Request;
import com.lonepulse.robozombie.response.AsyncHandler;

/**
 * <p>An interface which represents a dummy endpoint which tests asynchronous request invocation features.
 * 
 * @category test
 * <br><br> 
 * @version 1.1.1
 * <br><br> 
 * @since 1.2.4
 * <br><br> 
 * @author <a href="mailto:lahiru@lonepulse.com">Lahiru Sahan Jayasinghe</a>
 */
@Asynchronous
@Endpoint(host = "0.0.0.0", port = "8080")
public interface AsyncEndpoint {
	
	/**
	 * <p>Sends a request asynchronously using @{@link Asynchronous} and {@link AsyncHandler}. 
	 * 
	 * @param asyncHandler
	 * 			the {@link AsyncHandler} which handles the results of the asynchronous request
	 * 
	 * @return {@code null}, since the request is processed asynchronously
	 * 
	 * @since 1.2.4
	 */
	@Request(path = "/asyncsuccess")
	public String asyncSuccess(AsyncHandler<String> asyncHandler);
	
	/**
	 * <p>Sends a request asynchronously using @{@link Asynchronous} and {@link AsyncHandler} 
	 * which returns response code that signifies a failure. This should invoke 
	 * {@link AsyncHandler#onFailure(org.apache.http.HttpResponse)} on the provided callback. 
	 * 
	 * @param asyncHandler
	 * 			the {@link AsyncHandler} which handles the results of the asynchronous request
	 * 
	 * @since 1.2.4
	 */
	@Request(path = "/asyncfailure")
	public void asyncFailure(AsyncHandler<String> asyncHandler);
	
	/**
	 * <p>Sends a request asynchronously using @{@link Asynchronous} but does not expect the 
	 * response to be handled using an {@link AsyncHandler}.
	 * 
	 * @since 1.2.4
	 */
	@Request(path = "/asyncnohandling")
	public void asyncNoHandling();
	
	/**
	 * <p>Processes a successful execution, but the user provided implementation of the callback 
	 * {@link AsyncHandler#onSuccess(org.apache.http.HttpResponse, Object)} throws an exception.
	 * 
	 * @param asyncHandler
	 * 			the {@link AsyncHandler} which is expected to throw an exception in <i>onSuccess</i>
	 * 
	 * @since 1.2.4
	 */
	@Request(path = "/successcallbackerror")
	public void asyncSuccessCallbackError(AsyncHandler<String> asyncHandler);
	
	/**
	 * <p>Processes a failed execution, but the user provided implementation of the callback 
	 * {@link AsyncHandler#onFailure(org.apache.http.HttpResponse) throws an exception.
	 * 
	 * @param asyncHandler
	 * 			the {@link AsyncHandler} which is expected to throw an exception in <i>onFailure</i>
	 * 
	 * @since 1.2.4
	 */
	@Request(path = "/failurecallbackerror")
	public void asyncFailureCallbackError(AsyncHandler<String> asyncHandler);
}
