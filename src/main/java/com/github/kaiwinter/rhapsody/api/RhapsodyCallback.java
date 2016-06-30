package com.github.kaiwinter.rhapsody.api;

/**
 * A callback for starting asynchronous API requests.
 *
 * @param <T>
 *           The type of queried data
 */
public interface RhapsodyCallback<T> {

   /**
    * Called on a successful connection.
    * 
    * @param data
    *           the result of the request
    */
   void onSuccess(T data);

   /**
    * Called on failure. This may be a HTTP error or a connection error.
    * 
    * @param throwable
    *           the causing throwable in case of a connection error, the status message is wrapped in a Throwable
    * @param code
    *           the HTTP code, or -1 if not an HTTP error
    */
   void onFailure(Throwable throwable, int code);
}
