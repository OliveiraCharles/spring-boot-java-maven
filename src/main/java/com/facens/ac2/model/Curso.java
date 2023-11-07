package com.facens.ac2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cursos")
public class Curso {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private double nota01 = 0.0;
  private double nota02 = 0.0;
  private double notaFinal = 0.0;
  private double media = 0.0;
  private double frequencia = 1.0;

  public Curso(String name) {
    this.name = name;
  }

  public boolean estaAprovado() {
    double media;
    if (frequencia < 75) {
      return false;
    } else {
      media = (nota01 + nota02) / 2;
      // System.out.println("Media: " + media);
      if (media < 30) {
        // System.out.println("Reprovado: Media < 30!" + media);
        return false;
      } else {
        if (media >= 70) {
          // System.out.println("Aprovado: Media >= 70!");
          return true;
        } else {
          if ((media + notaFinal) / 2 >= 50) {
            // System.out.println("Aprovado: Media2 >= 50!");
            return true;
          } else {
            // System.out.println("Reprovado: Media2 < 50!");
            return false;
          }
        }
      }
    }
  }

  public void show() {
    System.out.println("Nome: " + getName());
    System.out.println("\tFrequência:\t " + getFrequencia() * 100 + "%");
    System.out.println("\tNota 01:\t " + getNota01());
    System.out.println("\tNota 02:\t " + getNota02());
    System.out.println("\tNota Final:\t " + getNotaFinal());
    if (estaAprovado()) {
      System.out.println("\tAprovado");
    } else {
      System.out.println("\tReprovado");
    }
  }
}
