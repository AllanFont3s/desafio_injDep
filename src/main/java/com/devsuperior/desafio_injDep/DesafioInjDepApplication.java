package com.devsuperior.desafio_injDep;

import com.devsuperior.desafio_injDep.entities.Order;
import com.devsuperior.desafio_injDep.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioInjDepApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioInjDepApplication.class, args);
    }

    @Autowired
    OrderService orderService;


    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("ENTRADA ");
        System.out.print("Digite o id do produto: ");
        Integer id = sc.nextInt();
        System.out.print("Digite o valor do produto: ");
        double basic = sc.nextDouble();
        System.out.print("Digite o valor do desconto: ");
        double discount = sc.nextDouble();
        Order order = new Order(id, basic, discount);

        System.out.println("Pedido código " + order.getCode() );
        System.out.println("Valor total: " + orderService.total(order) );


        sc.close();
    }
}
