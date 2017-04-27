package com.giphy.sdk.core.network.api;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.giphy.sdk.core.models.enums.LangType;
import com.giphy.sdk.core.models.enums.MediaType;
import com.giphy.sdk.core.models.enums.RatingType;
import com.giphy.sdk.core.network.response.CategoriesResponse;
import com.giphy.sdk.core.network.response.GifResponse;
import com.giphy.sdk.core.network.response.MultipleGifsResponse;

import java.util.List;

/**
 * Created by bogdantmm on 4/19/17.
 */

public interface GPHApi {
    /**
     * Search for gifs or stickers
     * @param searchQuery search query term or phrase
     * @param type can be sticker or gif
     * @param limit (optional) number of results to return, maximum 100. Default 25.
     * @param offset (optional) results offset, defaults to 0.
     * @param rating (optional) limit results to those rated (y,g, pg, pg-13 or r).
     * @param lang  (optional) specify default country for regional content; format is 2-letter ISO 639-1 country code.
     * @return
     */
    @NonNull
    public AsyncTask search(@NonNull String searchQuery, @Nullable MediaType type, @Nullable Integer limit,
                            @Nullable Integer offset, @Nullable RatingType rating,
                            @Nullable LangType lang,
                            @NonNull final CompletionHandler<MultipleGifsResponse> completionHandler);

    /**
     * Get the trending gifs or stickers
     * @param type can be sticker or gif
     * @param limit  (optional) limits the number of results returned. By default returns 25 results.
     * @param offset  (optional) results offset, defaults to 0);
     * @param rating  (optional) limit results to those rated (y,g, pg, pg-13 or r).
     * @return
     */
    @NonNull
    public AsyncTask trending(@Nullable MediaType type, @Nullable Integer limit,
                              @Nullable Integer offset, @Nullable RatingType rating,
                              @NonNull final CompletionHandler<MultipleGifsResponse> completionHandler);

    /**
     * The translate API draws on search, but uses the Giphy "special sauce" to handle translating from one vocabulary to another.
     * @param term term or phrase to translate into a GIF
     * @param type can be sticker or gif
     * @param rating  (optional) limit results to those rated (y,g, pg, pg-13 or r).
     * @param lang  (optional) specify default country for regional content; format is 2-letter ISO 639-1 country code.
     * @return
     */
    @NonNull
    public AsyncTask translate(@NonNull String term, @Nullable MediaType type, @Nullable RatingType rating,
                               @Nullable LangType lang,
                               @NonNull final CompletionHandler<GifResponse> completionHandler);

    /**
     * Returns a random GIF, limited by tag. Excluding the tag parameter will return a random GIF from the Giphy catalog.
     * @param tag the GIF tag to limit randomness by
     * @param type
     * @param rating limit results to those rated (y,g, pg, pg-13 or r).
     * @return
     */
    @NonNull
    public AsyncTask random(@NonNull String tag, @Nullable MediaType type, @Nullable RatingType rating,
                            @NonNull final CompletionHandler<GifResponse> completionHandler);


    /**
     * Returns a list of categories
     * @param limit
     * @param offset
     * @param completionHandler
     * @return
     */
    @NonNull
    public AsyncTask categories(@Nullable Integer limit, @Nullable Integer offset,
                                @NonNull final CompletionHandler<CategoriesResponse> completionHandler);

    /**
     * Returns a list of subcategories for a category
     * @param categoryEncodedName
     * @param limit
     * @param offset
     * @param completionHandler
     * @return
     */
    @NonNull
    public AsyncTask subcategories(@NonNull String categoryEncodedName,
                                   @Nullable Integer limit, @Nullable Integer offset,
                                   @NonNull final CompletionHandler<CategoriesResponse> completionHandler);

    /**
     * Returns a list of gifs based on category & subcategory
     * @param categoryEncodedName
     * @param subcategoryEncodedName
     * @param limit
     * @param offset
     * @param completionHandler
     * @return
     */
    @NonNull
    public AsyncTask gifsByCategory(@NonNull String categoryEncodedName,
                                    @NonNull String subcategoryEncodedName,
                                    @Nullable Integer limit, @Nullable Integer offset,
                                    @NonNull final CompletionHandler<MultipleGifsResponse> completionHandler);

    /**
     * Returns meta data about a GIF, by GIF id
     * @param gifId the id of the gif we want to return
     * @return
     */
    @NonNull
    public AsyncTask gifById(@NonNull String gifId,
                             @NonNull final CompletionHandler<GifResponse> completionHandler);

    /**
     * Returns meta data about multiple gifs
     * @param gifIds the list of ids of the gifs we want to return
     * @return
     */
    @NonNull
    public AsyncTask gifByIds(@NonNull List<String> gifIds,
                              @NonNull final CompletionHandler<MultipleGifsResponse> completionHandler);
}

