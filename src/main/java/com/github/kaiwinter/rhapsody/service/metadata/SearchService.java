package com.github.kaiwinter.rhapsody.service.metadata;

import java.util.Collection;

import com.github.kaiwinter.rhapsody.model.AccountData;
import com.github.kaiwinter.rhapsody.model.AlbumData;
import com.github.kaiwinter.rhapsody.model.AlbumData.Track;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Wrapper of the Search REST API.
 * 
 * @see <a href="https://developer.rhapsody.com/api#search">https://developer.rhapsody.com/api#search</a>
 */
public interface SearchService {

   /**
    * Returns an array of typed results by substring.
    *  Optionally scoped by content type . 
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param type
    *           The content type (artist, album, track, playlist). 
    * @param q
    *           The search query. 
    * @param limit
    *           The number of tracks to load, if <code>null</code> the default value is used (20)
    * @return the {@link Track}
    */
   @GET("/v1/search/typeahead")
   Collection<Track> search(
      @Query("apikey") String apikey,
      @Query("pretty") boolean pretty, 
      @Query("catalog") String catalog,
      @Query("type") String type, 
      @Query("q") String q,
      @Query("limit") Integer limit);
   
}