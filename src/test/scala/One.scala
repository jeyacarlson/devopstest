import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class One extends Simulation {

	val httpProtocol = http
		.baseURL("https://api.accenturejumpstart.com/signet-dev")
		// .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		// .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36")

	val headers_6 = Map(
		"Content-Type" -> "application/json",
		"accept" -> "application/json, text/plain, */*")

	object updateItem {
		val feeder = tsv("items.tsv").circular
		val updateItem = feed(feeder)
			.exec(http("updateItem")
			.put("/update")
			.headers(headers_6)
			.body(StringBody("${json}")).asJSON
			.check(status.is(200)))
	}

	val scn = scenario("API Test").exec(updateItem.updateItem);
	setUp(scn.inject(rampUsers(10) over (10 seconds))).protocols(httpProtocol);
	
}