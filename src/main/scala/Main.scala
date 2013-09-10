import akka.actor._
import scala.language.postfixOps
import scala.language.implicitConversions
import scala.concurrent.duration._

object Main {

  def main(args: Array[String]) {

    val system = ActorSystem("Default")

    // Create the 'greeter' actor
    val greeter = system.actorOf(Props[Greeter], "greeter")

    // Create an "actor-in-a-box"
    val inbox = Inbox.create(system)

    // Tell the 'greeter' to change its 'greeting' message
    greeter.tell(WhoToGreet("akka"), ActorRef.noSender)

    // Ask the 'greeter for the latest 'greeting'
    // Reply should go to the "actor-in-a-box"
    inbox.send(greeter, Greet)

    // Wait 5 seconds for the reply with the 'greeting' message
    val Greeting(message1) = inbox.receive(5 seconds)
    println(s"Greeting: $message1")

    // Change the greeting and ask for it again
    greeter.tell(WhoToGreet("typesafe"), ActorRef.noSender)
    inbox.send(greeter, Greet)
    val Greeting(message2) = inbox.receive(5 seconds)
    println(s"Greeting: $message2")

    system.shutdown()
  }
}

