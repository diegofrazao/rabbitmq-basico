import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class Produtor {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String NOME_FILA = "plica";
            channel.queueDeclare(NOME_FILA, true, false, false, null);

            String mensagem1 = "Mensagem 1 .";
            String mensagem2 = "Mensagem 2 ..";
            String mensagem3 = "Mensagem 3 ...";
            String mensagem4 = "Mensagem 4 ....";
            String mensagem5 = "Mensagem 5 .....";
            String mensagem6 = "Mensagem 6 ......";
            String mensagem7 = "Mensagem 7 .......";
            String mensagem8 = "DIEGO FRANKNEY FRAZÃO DA SILVA";

            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem1.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem2.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem3.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem4.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem5.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem6.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem7.getBytes());
            channel.basicPublish("", NOME_FILA, MessageProperties.PERSISTENT_TEXT_PLAIN, mensagem8.getBytes());

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


