package com.example.android.bookapi;

import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String jsonResponse="{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 2100,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"MoXpe6H2B5gC\",\n" +
            "   \"etag\": \"Hp61ZJkbkSU\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/MoXpe6H2B5gC\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Android in The Attic\",\n" +
            "    \"authors\": [\n" +
            "     \"Nicholas Allan\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Hachette UK\",\n" +
            "    \"publishedDate\": \"2013-01-03\",\n" +
            "    \"description\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don't have any fun. But then Alfie discovers how to override Auntie Anne-Droid's programming and nothing can stop them eating all the Cheeki Choko Cherry Cakes they like ... until the real aunt Edna is kidnapped!\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781444905465\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"1444905465\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": true,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 192,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Juvenile Fiction\"\n" +
            "    ],\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"1.2.2.0.preview.2\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=MoXpe6H2B5gC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.co.in/books?id=MoXpe6H2B5gC&printsec=frontcover&dq=android&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://market.android.com/details?id=book-MoXpe6H2B5gC\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"saleability\": \"FOR_SALE\",\n" +
            "    \"isEbook\": true,\n" +
            "    \"listPrice\": {\n" +
            "     \"amount\": 250.16,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"retailPrice\": {\n" +
            "     \"amount\": 175.11,\n" +
            "     \"currencyCode\": \"INR\"\n" +
            "    },\n" +
            "    \"buyLink\": \"https://play.google.com/store/books/details?id=MoXpe6H2B5gC&rdid=book-MoXpe6H2B5gC&rdot=1&source=gbs_api\",\n" +
            "    \"offers\": [\n" +
            "     {\n" +
            "      \"finskyOfferType\": 1,\n" +
            "      \"listPrice\": {\n" +
            "       \"amountInMicros\": 2.5016E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      },\n" +
            "      \"retailPrice\": {\n" +
            "       \"amountInMicros\": 1.7511E8,\n" +
            "       \"currencyCode\": \"INR\"\n" +
            "      }\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"IN\",\n" +
            "    \"viewability\": \"PARTIAL\",\n" +
            "    \"embeddable\": true,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED_FOR_ACCESSIBILITY\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": true,\n" +
            "     \"acsTokenLink\": \"http://books.google.co.in/books/download/Android_in_The_Attic-sample-epub.acsm?id=MoXpe6H2B5gC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api\"\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=MoXpe6H2B5gC&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"SAMPLE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Aunt Edna has created a no-nonsense nanny android to make sure Billy and Alfie don&#39;t have any fun.\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lookup the recyclerview in activity layout
        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.rvBooks);

        BookAdapter mAdapter=new BookAdapter(this,extractBooks(jsonResponse));

        rvBooks.setAdapter(mAdapter);

        rvBooks.setLayoutManager(new LinearLayoutManager(this));

    }

    public static List<Book_Data> extractBooks(String booklistJSON) {

        Log.v("extractEarthquakes","JsonResponse extracted");

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(booklistJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Book_Data> books = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.
            JSONObject baseJsonResponse=new JSONObject(booklistJSON);
            JSONArray ab=baseJsonResponse.getJSONArray("items");

            for(int i=0;i<ab.length();i++)
            {
                JSONObject c=ab.getJSONObject(i);
                JSONObject d=c.getJSONObject("volumeInfo");
                JSONObject im=d.getJSONObject("imageLinks");
                String imglink=im.getString("smallThumbnail");
                //int imglink=R.mipmap.ic_launcher;
                JSONArray p=d.getJSONArray("authors");
                String author=p.toString();
                String tle=d.getString("title");
                JSONObject s=c.getJSONObject("saleInfo");
                JSONObject cp=s.getJSONObject("listPrice");
                String rprice=cp.getString("amount");
                String prlink=s.getString("buyLink");
                Log.v("stage1","finished parsing"+imglink);
                Book_Data book=new Book_Data(imglink,tle,author,rprice,prlink);
                Log.v("stage1","finished parsing"+imglink);
                books.add(book);
            }

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return books;
    }
}
