package apiRest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.Gson;
import apiRest.dtoTiempo.Dto;

/**
 * Clase que se comunica con la API de OpenWheather y obtiene
 * el JSON con los datos del tiempo.
 * 
 * 
 * @author javier
 *
 */
public class GeneradorJSON {

  private static final String KEY = "ba80d45922f7cd2ad89355c89bc7d601";
  private static final String ROOT_ENDPOINT = "https://api.openweathermap.org";
  private static final String PATH = "/data/2.5/forecast";
  private static final String PARAMS = "&appid=" + KEY + "&units=metric&lang=es";



  public static String getResponseOpenWheather(String ciudad) throws IOException, InterruptedException {
    String endpoint = ROOT_ENDPOINT + PATH + "?q=" + ciudad + PARAMS;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endpoint))
        .GET()
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    return response.body();
  }



  public static void generadorTiempo5Dias(String json) {
    Gson gson = new Gson();
    Dto dto = gson.fromJson(json, Dto.class);
    
    double media[] = mediaTemp(dto);
    double mediaMin[] = mediaMin(dto);
    double mediaMax[] = mediaMax(dto);
    
    System.out.println("El tiempo en " + dto.getCity().getName());

    int medicion = 1;
    int countMedia = 1;
    String fecha = dto.getList().get(0).getDtTxt().substring(0, 10);
    for (var resultados : dto.getList()) {

      if (!resultados.getDtTxt().substring(0, 10).equals(fecha)) {
        fecha = resultados.getDtTxt().substring(0, 10);
        System.out.println("\nMedición " + medicion++);
        System.out.println("----------------------");
        System.out.println("Fecha: " + resultados.getDtTxt().substring(0, 10));
        System.out.printf("Temperatura media: %.2f %n", media[countMedia]);
        System.out.println("Temp minima: " + mediaMin[countMedia]);
        System.out.println("Temp maxima: " + mediaMax[countMedia]);
        countMedia++;
      }

    }

  }
  

  private static double[] mediaTemp(Dto dto) {
    double media[] = new double[6];
    int posicion = 0;
    double[] counter = new double[6];
    String fecha = dto.getList().get(0).getDtTxt().substring(0, 10);
    for (var results : dto.getList()) {
      if (!results.getDtTxt().substring(0, 10).equals(fecha)) {
        fecha = results.getDtTxt().substring(0, 10);
        posicion++;
      } else {
        media[posicion] = media[posicion] + results.getMain().getTemp();
        counter[posicion] = counter[posicion] + 1;
      }
    }
    
    double mediaFinal[] = new double[6];
    for (int i = 0; i < mediaFinal.length; i++) {
      mediaFinal[i] = media[i] / counter[i];
    }
    
    
    return mediaFinal;
  }



  public static double[] mediaMin(Dto dto) {
    double[] media = new double[6];
    int posicion = 0;
    double min = 100;
    
    String fecha = dto.getList().get(0).getDtTxt().substring(0, 10);
    for (var results : dto.getList()) {
      if (!results.getDtTxt().substring(0, 10).equals(fecha)) {
        fecha = results.getDtTxt().substring(0, 10);
        posicion++;
        min = 100;
      } else {
        if (min > results.getMain().getTempMin()) {
          min = results.getMain().getTempMin();
          media[posicion] = min;
        }
      }
    }
    
    return media;
  }

  private static double[] mediaMax(Dto dto) {
    double[] media = new double[6];
    int posicion = 0;
    double max = -100;
    
    String fecha = dto.getList().get(0).getDtTxt().substring(0, 10);
    for (var results : dto.getList()) {
      if (!results.getDtTxt().substring(0, 10).equals(fecha)) {
        fecha = results.getDtTxt().substring(0, 10);
        posicion++;
        max = -100;
      } else {
        if (max < results.getMain().getTempMin()) {
          max = results.getMain().getTempMin();
          media[posicion] = max;
        }
      }
    }
    
    return media;
  }


}
