Assimgents

Assignment 1
From the list of strings in format “net, tax, gross” calculate the overall percentage of taxes included in the final price.

public ??? calcaulteRealTax(List<String> strings) {
 ???
}

- 100000.00 < net < 100000.00
- 100000.00 < tax < 100000.00
- 100000.00 < gross < 100000.00

* What data type and why should this method return ?

Assignment 2
Having a list of strings, find the most frequently occurring string in the list.

public String mostOccuring(List<String> strings) {
 ???
}

Assignment 3
Having the list of Request objects find IP addresses that send more than X requests in a time window of 10 seconds.

public class Request {
	public final String ip;
	public final LocalDateTime timestamp;
	public final String body;
}

1 < X < 100

Assignment 3 part 2
Implement the same feature but the time window span Y can be provided by the user.

1 < Y < 7200


Requirements
All assignments should be done in separate packages under the provider package.
All should be done in pure Java without any libs except Junit related.
All assignments should be done on branch solutions and PR to master should be created when finished. 
Use Java 17 for coding.
Unit tests required for all assignments, preferably in Junit5.
Each assignment should be done in a separate commit.

<!DOCTYPE html>

<html>

<h2>Simple Url Shortener.</h2> 
<div text-align: justify;>
It uses CRC32C to generate a unique hash of reasonable length for every inputted url. Whole application is Spring Boot based. It also exposes two REST style endpoints to communicate with the outside world. One endpoint is responsible for shortening of the urls while the second is response for retrieving already shortened urls. Persistence is provided by H2 in-memory database so there is no persistence between restarts of application.
 </div>
</html>

</html>

