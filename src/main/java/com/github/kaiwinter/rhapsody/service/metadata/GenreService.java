package com.github.kaiwinter.rhapsody.service.metadata;

import java.util.Collection;

import com.github.kaiwinter.rhapsody.model.AlbumData;
import com.github.kaiwinter.rhapsody.model.GenreData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Wrapper of the Genre REST API.
 * 
 * @see <a href="https://developer.rhapsody.com/api#genres">https://developer.rhapsody.com/api#genres</a>
 */
public interface GenreService {

   /**
    * Returns a hierarchical map of all genres and subgenres.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param callBack
    *           callback to which the result is passed
    */
   @GET("/v1/genres")
   void getGenres( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      Callback<Collection<GenreData>> callBack);

   /**
    * Returns a list of all new releases by genre.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param genreId
    *           the ID of the genre to load new releases
    * @param limit
    *           the number of releases which are loaded, if <code>null</code> the servers default value is used
    * @param callBack
    *           callback to which the result is passed
    */
   @GET("/v1/genres/{genreId}/albums/new")
   void getNewReleases( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      @Path("genreId") String genreId, //
      @Query("limit") Integer limit, //
      Callback<Collection<AlbumData>> callBack);
}