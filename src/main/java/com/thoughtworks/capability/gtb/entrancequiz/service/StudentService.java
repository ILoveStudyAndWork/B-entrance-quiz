package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    static List<Student> students = new ArrayList<>();

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
}
