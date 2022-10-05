
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class TodoSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://localhost:9500")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.9,el;q=0.8,fi;q=0.7")
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "none"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Accept", "application/json,*/*"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Origin", "http://localhost:9500"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_15 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_31 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Origin", "http://localhost:9500"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );
  
  private Map<CharSequence, String> headers_34 = Map.ofEntries(
    Map.entry("Cache-Control", "no-cache"),
    Map.entry("Pragma", "no-cache"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("accept", "application/json"),
    Map.entry("sec-ch-ua", "Google Chrome\";v=\"105\", \"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"105"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "macOS")
  );


  private ScenarioBuilder scn = scenario("TodoSimulation")
    .exec(
      http("request_0")
        .get("/swagger-ui/index.html")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/v3/api-docs/swagger-config")
            .headers(headers_1),
          http("request_2")
            .get("/v3/api-docs")
            .headers(headers_2)
        )
    )
    .pause(20)
    .exec(
      http("request_3")
        .get("/swagger-ui/index.html")
        .headers(headers_0)
        .resources(
          http("request_4")
            .get("/v3/api-docs/swagger-config")
            .headers(headers_1),
          http("request_5")
            .get("/v3/api-docs")
            .headers(headers_2)
        )
    )
    .pause(10)
    .exec(
      http("request_6")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0006_request.json"))
    )
    .pause(1)
    .exec(
      http("request_7")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0007_request.json"))
    )
    .pause(5)
    .exec(
      http("request_8")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0008_request.json"))
    )
    .pause(173)
    .exec(
      http("request_9")
        .get("/swagger-ui/index.html")
        .headers(headers_0)
        .resources(
          http("request_10")
            .get("/v3/api-docs/swagger-config")
            .headers(headers_1),
          http("request_11")
            .get("/v3/api-docs")
            .headers(headers_2)
        )
    )
    .pause(13)
    .exec(
      http("request_12")
        .get("/swagger-ui/index.html")
        .headers(headers_0)
        .resources(
          http("request_13")
            .get("/v3/api-docs/swagger-config")
            .headers(headers_1),
          http("request_14")
            .get("/v3/api-docs")
            .headers(headers_2)
        )
    )
    .pause(47)
    .exec(
      http("request_15")
        .get("/swagger-ui/index.html")
        .headers(headers_15)
    )
    .pause(1)
    .exec(
      http("request_16")
        .get("/v3/api-docs/swagger-config")
        .headers(headers_1)
        .resources(
          http("request_17")
            .get("/v3/api-docs")
            .headers(headers_2)
        )
    )
    .pause(6)
    .exec(
      http("request_18")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0018_request.json"))
    )
    .pause(2)
    .exec(
      http("request_19")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0019_request.json"))
    )
    .pause(14)
    .exec(
      http("request_20")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0020_request.json"))
    )
    .pause(1)
    .exec(
      http("request_21")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0021_request.json"))
    )
    .pause(17)
    .exec(
      http("request_22")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0022_request.json"))
        .resources(
          http("request_23")
            .post("/api/todos")
            .headers(headers_6)
            .body(RawFileBody("todosimulation/0023_request.json"))
        )
    )
    .pause(4)
    .exec(
      http("request_24")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0024_request.json"))
    )
    .pause(8)
    .exec(
      http("request_25")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0025_request.json"))
        .check(status().is(400))
    )
    .pause(7)
    .exec(
      http("request_26")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0026_request.json"))
        .check(status().is(400))
    )
    .pause(7)
    .exec(
      http("request_27")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0027_request.json"))
    )
    .pause(5)
    .exec(
      http("request_28")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0028_request.json"))
    )
    .pause(15)
    .exec(
      http("request_29")
        .post("/api/todos")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0029_request.json"))
    )
    .pause(9)
    .exec(
      http("request_30")
        .get("/api/todos")
        .headers(headers_1)
    )
    .pause(27)
    .exec(
      http("request_31")
        .delete("/api/todos/56")
        .headers(headers_31)
        .check(status().is(500))
    )
    .pause(7)
    .exec(
      http("request_32")
        .delete("/api/todos/70")
        .headers(headers_31)
        .check(status().is(500))
    )
    .pause(9)
    .exec(
      http("request_33")
        .delete("/api/todos/2")
        .headers(headers_31)
    )
    .pause(29)
    .exec(
      http("request_34")
        .get("/api/todos/50")
        .headers(headers_34)
    )
    .pause(14)
    .exec(
      http("request_35")
        .get("/api/todos/90")
        .headers(headers_34)
    )
    .pause(3)
    .exec(
      http("request_36")
        .get("/api/todos/4")
        .headers(headers_34)
    )
    .pause(6)
    .exec(
      http("request_37")
        .get("/api/todos/7")
        .headers(headers_34)
    )
    .pause(11)
    .exec(
      http("request_38")
        .get("/api/todos/todo/%7Btitle%7D?title=David")
        .headers(headers_34)
    )
    .pause(7)
    .exec(
      http("request_39")
        .get("/api/todos/todo/%7Btitle%7D?title=david")
        .headers(headers_34)
    )
    .pause(9)
    .exec(
      http("request_40")
        .get("/api/todos/todo/%7Btitle%7D?title=sam")
        .headers(headers_34)
    )
    .pause(6)
    .exec(
      http("request_41")
        .get("/api/todos/todo/%7Btitle%7D?title=string")
        .headers(headers_34)
    )
    .pause(6)
    .exec(
      http("request_42")
        .get("/api/todos/todo/%7Btitle%7D?title=strings")
        .headers(headers_34)
    )
    .pause(30)
    .exec(
      http("request_43")
        .put("/api/todos/23")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0043_request.json"))
        .check(status().is(500))
    )
    .pause(10)
    .exec(
      http("request_44")
        .put("/api/todos/34")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0044_request.json"))
        .check(status().is(500))
    )
    .pause(9)
    .exec(
      http("request_45")
        .put("/api/todos/3")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0045_request.json"))
    )
    .pause(8)
    .exec(
      http("request_46")
        .put("/api/todos/3")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0046_request.json"))
    )
    .pause(19)
    .exec(
      http("request_47")
        .put("/api/todos/3")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0047_request.json"))
    )
    .pause(7)
    .exec(
      http("request_48")
        .put("/api/todos/3")
        .headers(headers_6)
        .body(RawFileBody("todosimulation/0048_request.json"))
    )
    .pause(8)
    .exec(
      http("request_49")
        .get("/api/todos")
        .headers(headers_1)
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
