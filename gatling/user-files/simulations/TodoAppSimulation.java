
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class TodoAppSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:9500")
      .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.9")
      .doNotTrackHeader("1")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/106.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Cache-Control", "no-cache");
    headers_0.put("Content-Type", "application/json");
    headers_0.put("Origin", "http://localhost:9500");
    headers_0.put("Pragma", "no-cache");
    headers_0.put("Sec-Fetch-Dest", "empty");
    headers_0.put("Sec-Fetch-Mode", "cors");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("sec-ch-ua", "Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_8 = new HashMap<>();
    headers_8.put("Cache-Control", "no-cache");
    headers_8.put("Pragma", "no-cache");
    headers_8.put("Sec-Fetch-Dest", "empty");
    headers_8.put("Sec-Fetch-Mode", "cors");
    headers_8.put("Sec-Fetch-Site", "same-origin");
    headers_8.put("sec-ch-ua", "Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99");
    headers_8.put("sec-ch-ua-mobile", "?0");
    headers_8.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_9 = new HashMap<>();
    headers_9.put("Cache-Control", "no-cache");
    headers_9.put("Pragma", "no-cache");
    headers_9.put("Sec-Fetch-Dest", "empty");
    headers_9.put("Sec-Fetch-Mode", "cors");
    headers_9.put("Sec-Fetch-Site", "same-origin");
    headers_9.put("accept", "application/json");
    headers_9.put("sec-ch-ua", "Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99");
    headers_9.put("sec-ch-ua-mobile", "?0");
    headers_9.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_16 = new HashMap<>();
    headers_16.put("Cache-Control", "no-cache");
    headers_16.put("Origin", "http://localhost:9500");
    headers_16.put("Pragma", "no-cache");
    headers_16.put("Sec-Fetch-Dest", "empty");
    headers_16.put("Sec-Fetch-Mode", "cors");
    headers_16.put("Sec-Fetch-Site", "same-origin");
    headers_16.put("sec-ch-ua", "Chromium\";v=\"106\", \"Google Chrome\";v=\"106\", \"Not;A=Brand\";v=\"99");
    headers_16.put("sec-ch-ua-mobile", "?0");
    headers_16.put("sec-ch-ua-platform", "macOS");


    ScenarioBuilder scn = scenario("TodoAppSimulation")
      .exec(
        http("request_0")
          .post("/api/todos")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0000_request.json"))
      )
      .pause(1)
      .exec(
        http("request_1")
          .post("/api/todos")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0001_request.json"))
          .resources(
            http("request_2")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0002_request.json")),
            http("request_3")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0003_request.json")),
            http("request_4")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0004_request.json")),
            http("request_5")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0005_request.json")),
            http("request_6")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0006_request.json")),
            http("request_7")
              .post("/api/todos")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0007_request.json"))
          )
      )
      .pause(7)
      .exec(
        http("request_8")
          .get("/api/todos")
          .headers(headers_8)
      )
      .pause(20)
      .exec(
        http("request_9")
          .get("/api/todos/98")
          .headers(headers_9)
      )
      .pause(1)
      .exec(
        http("request_10")
          .get("/api/todos/98")
          .headers(headers_9)
          .resources(
            http("request_11")
              .get("/api/todos/98")
              .headers(headers_9)
          )
      )
      .pause(3)
      .exec(
        http("request_12")
          .get("/api/todos/100")
          .headers(headers_9)
      )
      .pause(4)
      .exec(
        http("request_13")
          .get("/api/todos/34")
          .headers(headers_9)
      )
      .pause(10)
      .exec(
        http("request_14")
          .get("/api/todos/todo/%7Btitle%7D?title=sam")
          .headers(headers_9)
      )
      .pause(7)
      .exec(
        http("request_15")
          .get("/api/todos/todo/%7Btitle%7D?title=dav")
          .headers(headers_9)
      )
      .pause(8)
      .exec(
        http("request_16")
          .delete("/api/todos/43")
          .headers(headers_16)
          .check(status().is(500))
      )
      .pause(8)
      .exec(
        http("request_17")
          .delete("/api/todos/50")
          .headers(headers_16)
          .check(status().is(500))
      )
      .pause(15)
      .exec(
        http("request_18")
          .put("/api/todos/18")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0018_request.json"))
      )
      .pause(7)
      .exec(
        http("request_19")
          .put("/api/todos/20")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0019_request.json"))
          .check(status().is(500))
      )
      .pause(7)
      .exec(
        http("request_20")
          .put("/api/todos/50")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0020_request.json"))
          .check(status().is(500))
          .resources(
            http("request_21")
              .put("/api/todos/50")
              .headers(headers_0)
              .body(RawFileBody("todoappsimulation/0021_request.json"))
              .check(status().is(500))
          )
      )
      .pause(5)
      .exec(
        http("request_22")
          .put("/api/todos/78")
          .headers(headers_0)
          .body(RawFileBody("todoappsimulation/0022_request.json"))
          .check(status().is(500))
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
