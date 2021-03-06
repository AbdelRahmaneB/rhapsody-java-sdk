package com.github.kaiwinter.rhapsody.service.metadata;

import java.util.Collection;

import com.github.kaiwinter.rhapsody.model.AlbumData;
import com.github.kaiwinter.rhapsody.model.ArtistData;
import com.github.kaiwinter.rhapsody.model.BioData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Wrapper of the Artist REST API.
 *
 * @see <a href="https://developer.rhapsody.com/api#artists">https://developer.rhapsody.com/api#artists</a>
 */
public interface ArtistService {

   /**
    * Asynchronously returns a given artist's name, ID and primary genre.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param artistId
    *           the ID of the artist to load
    * @param callBack
    *           callback to which the result is passed
    */
   @GET("/v1/artists/{artistId}")
   void getArtist( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      @Path("artistId") String artistId, //
      Callback<ArtistData> callBack);

   /**
    * Synchronously returns a given artist's name, ID and primary genre.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param artistId
    *           the ID of the artist to load
    * @return the {@link ArtistData}
    */
   @GET("/v1/artists/{artistId}")
   ArtistData getArtist( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      @Path("artistId") String artistId);

   /**
    * Returns biographical info for a given artist, including up to five short "blurbs" written by our editorial staff.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param artistId
    *           the ID of the artist to load
    * @param callBack
    *           callback to which the result is passed
    */
   @GET("/v1/artists/{artistId}/bio")
   void getBio( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      @Path("artistId") String artistId, //
      Callback<BioData> callBack);

   /**
    * Synchronously returns a list of an artist's new releases (if any), updated weekly.
    * 
    * @param apikey
    *           the API key
    * @param pretty
    *           if <code>true</code> pretty prints the JSON
    * @param catalog
    *           countries' catalog (two-letter country code, which is case-sensitive)
    * @param artistId
    *           the ID of the artist to load
    * @param limit
    *           the number of releases which are loaded, if <code>null</code> the servers default value is used
    * @return a list of an artist's new releases
    */
   @GET("/v1/artists/{artistId}/albums/new")
   Collection<AlbumData> getNewReleases( //
      @Query("apikey") String apikey, //
      @Query("pretty") boolean pretty, //
      @Query("catalog") String catalog, //
      @Path("artistId") String artistId, //
      @Query("limit") Integer limit);
}