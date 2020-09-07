package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.StudentGroup;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    static List<Student> students = new ArrayList<>();
    List<StudentGroup> groups = new ArrayList<>();

    public StudentService() throws Exception {
        setup();
    }

    public List<Student> setup() throws Exception {
        try {
            File file = new File("C:\\Users\\85067\\workspace\\GTB\\B-entrance-quiz\\students.txt");
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(
                        new FileInputStream(file), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String student;
                int id = 0;
                while ((student = bufferedReader.readLine()) != null) {
                    id += 1;
                    students.add(new Student(id, student));
                }
                bufferedReader.close();
            } else {
                throw new Exception("找不到指定的文件");
            }
        } catch (Exception e){
            throw new Exception("读取文件出错");
        }
        return students;
    }

    public List<Student> getAllStudent() {
        return students;
    }

    public List<StudentGroup> divide() {

        for (int i = 1; i <= 6; i++){
            StudentGroup group = new StudentGroup("Team " +i);
            groups.add(group);
        }

        Collections.shuffle(students);
        Iterator<Student> it = students.iterator();
        int groupIndex = 0;
        while (it.hasNext()){
            if (groupIndex == 6){
                groupIndex = 0;
            }
            Student student = it.next();
            groups.get(groupIndex).addToGroup(student);
            groupIndex += 1;
        }
        return groups;
    }
}
