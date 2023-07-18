package com.app.service;

import java.util.List;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StudentDTO;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repositiory.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService 
{
	@Autowired
	private StudentRepository studRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private CoursesService crservice;
 
	@Override
	public Student addStudent(StudentDTO studDTO)
	{
		Course course=crservice.findCourse(studDTO.getCid());
		Student student=mapper.map(studDTO, Student.class);   //DTO-->Entity
		
		course.addStudent(student);
		return studRepo.save(student);
	}

	@Override
	public List<Student> getallStudent() 
	{
		return studRepo.findAll();
	}

	@Override
	public String cancelAdmission(Long sid, Long cid) {
		Student student=studRepo.findById(sid).orElseThrow();
		Course course=crservice.findCourse(cid); //courseRepo.findById(cid)
		course.removeStudent(student);
		return "studRepo Remove Successfully";
	}
}
