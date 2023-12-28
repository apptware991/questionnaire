package com.example.questionApp.UI;

import com.example.questionApp.model.Questionnaire;
import com.example.questionApp.repository.QuestionnaireRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.Route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Route
public class QuestionnaireUI extends VerticalLayout {
    private final QuestionnaireRepository repository;
    private final Grid<Questionnaire> grid;
    private final TextField firstName;
    private final TextField lastName;
    private final IntegerField age;
    private final IntegerField experience;
   // private final MultiSelect skills;
    private CheckboxGroup<String> skillsCheckboxGroup = new CheckboxGroup<>("Skills");
    

    @Autowired
    public QuestionnaireUI(QuestionnaireRepository repository) {
        this.repository = repository;

        grid = new Grid<>(Questionnaire.class);
        grid.setColumns("firstName", "lastName","age","experience","skills");
        updateGrid();

        firstName = new TextField("firstName");
        lastName = new TextField("lastName");
        age = new IntegerField("age");
        experience = new IntegerField("experience");
        skillsCheckboxGroup.setItems("Java", "Spring", "MongoDB", "HTML", "CSS", "JavaScript");
        Button saveButton = new Button("Save", event -> saveUserDetails());
      //  Button addButton = new Button("Add Questionnaire", event -> addQuestionnaire());
        FormLayout formLayout = new FormLayout();
        formLayout.add(firstName, lastName, age, experience, skillsCheckboxGroup, saveButton,grid);

        add(formLayout);
        
    }

    private void saveUserDetails() {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setFirstName(firstName.getValue());
        questionnaire.setLastName(lastName.getValue());
        questionnaire.setAge(age.getValue());
        questionnaire.setExperience(experience.getValue());
        questionnaire.setSkills(skillsCheckboxGroup.getSelectedItems());
        repository.save(questionnaire);

        updateGrid();

        firstName.clear();
        lastName.clear();
        age.clear();
        experience.clear();
        skillsCheckboxGroup.deselectAll();
    }

    private void updateGrid() {
        grid.setItems(repository.findAll());
    }
}
