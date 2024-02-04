using EasyNetQ;

const string connectionString = "amqp://devuser:devuser@localhost:5672";
const string queueName = "testQueue";

var bus = RabbitHutch.CreateBus(connectionString, register => register.EnableConsoleLogger());
await bus.Advanced.QueueDeclareAsync(queueName);
Console.WriteLine("Вводи сообщения, и они тут же будут отправлены по шине");
while (true)
{
    var input = Console.ReadLine();
    await bus.SendReceive.SendAsync(queueName, input);
    Console.WriteLine($"Сообщение \"{input}\" было отправлено в шину");
}