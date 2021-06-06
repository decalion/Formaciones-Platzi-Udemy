package com.icaballero.arquitecturahexagonal.converters;

import org.mapstruct.Mapper;

import com.icaballero.arquitecturahexagonal.CourseRequest;
import com.icaballero.arquitecturahexagonal.domain.Course;

@Mapper
public interface CourseRequestToCourseConverter {

	Course converToCourse(CourseRequest course);
}
