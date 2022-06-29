package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Video;
import entities.Task;

public class Program {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("\nDados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char chooseLessonType = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if(chooseLessonType == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				list.add(new Video(title, url, seconds));
				
			}else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				list.add(new Task(title, description, questionCount));
			}
		}
		
		int totalCourseDuration = 0;		
		for (Lesson lesson : list) {
			totalCourseDuration += lesson.duration();
		}
		
		System.out.printf("%nDURAÇÃO TOTAL DO CURSO = %d segundos", totalCourseDuration);
		
		sc.close();
	}
	
}
