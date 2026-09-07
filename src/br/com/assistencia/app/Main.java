package br.com.assistencia.app;

import br.com.assistencia.service.ChatbotService;

public class Main {

    public static void main(String[] args) {

        ChatbotService chatbot = new ChatbotService();

        chatbot.iniciar();
    }
}