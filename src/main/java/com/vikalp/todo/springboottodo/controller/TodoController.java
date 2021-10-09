package com.vikalp.todo.springboottodo.controller;

import com.vikalp.todo.springboottodo.domain.Todo;
import com.vikalp.todo.springboottodo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

	@Autowired
	TodoRepository todoRepository;

	@GetMapping("/todo")
	public String getTodo(Model model) {
		model.addAttribute("todos", todoRepository.findAll());
		return "todo";
	}

	@PostMapping("/todoAdd")
	public String add(@RequestParam(required = false) String todoItem, Model model) {
		Todo todo = new Todo();
		todo.setTodoItem(todoItem);
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todo";
	}

	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		todoRepository.deleteById(id);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todo";
	}

	@PostMapping("/todoUpdate")
	public String update(@RequestParam(required = false) Long id, @RequestParam(required = false) String todoItem, Model model) {
		Todo todo = todoRepository.findById(id).get();
		todo.setTodoItem(todoItem);
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todo";
	}
}
