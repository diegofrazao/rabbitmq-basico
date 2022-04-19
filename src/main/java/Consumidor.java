import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;


public class Consumidor {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANGE_NAME, "fila_1");
        channel.queueBind(queueName, EXCHANGE_NAME, "fila_2");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback callback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);

            System.out.println("[+] Mensagem recebida para " +
                    delivery.getEnvelope().getRoutingKey() +
                    ": " + message);
        };

        channel.basicConsume(queueName, true, callback, consumerTag -> {
            System.out.println("Cancelaram a fila: " + queueName);
        });
    }
}


