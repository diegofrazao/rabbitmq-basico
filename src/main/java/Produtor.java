import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (
                Connection connection = connectionFactory.newConnection();
                Channel canal = connection.createChannel();
        ) {
            String mensagem1 = "Mensagem 1 .";
            String mensagem2 = "Mensagem 2 ..";
            String mensagem3 = "Mensagem 3 ...";
            String mensagem4 = "Mensagem 4 ....";
            String mensagem5 = "Mensagem 5 .....";
            String mensagem6 = "Mensagem 6 ......";
            String mensagem7 = "Mensagem 7 .......";
            String mensagem8 = "DIEGO FRANKNEY FRAZÃO DA SILVA";
            String NOME_FILA = "plica";

            //(queue, passive, durable, exclusive, autoDelete, arguments)
            canal.queueDeclare(NOME_FILA, false, false, false, null);

            // ​(exchange, routingKey, mandatory, immediate, props, byte[] body)
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem1.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem2.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem3.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem4.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem5.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem6.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem7.getBytes());
            canal.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem8.getBytes());

            System.out.println ("[x] Enviado: '" + mensagem1 + "'");
            System.out.println ("[x] Enviado: '" + mensagem2 + "'");
            System.out.println ("[x] Enviado: '" + mensagem3 + "'");
            System.out.println ("[x] Enviado: '" + mensagem4 + "'");
            System.out.println ("[x] Enviado: '" + mensagem5 + "'");
            System.out.println ("[x] Enviado: '" + mensagem6 + "'");
            System.out.println ("[x] Enviado: '" + mensagem7 + "'");
            System.out.println ("[x] Enviado: '" + mensagem8 + "'");
        }
    }
}


