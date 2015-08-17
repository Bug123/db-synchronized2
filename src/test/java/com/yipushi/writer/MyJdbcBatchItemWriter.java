package com.yipushi.writer;

import java.util.List;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.dao.DuplicateKeyException;

import com.yipushi.entity.Student;
import com.yipushi.handling.DataHandling;

public class MyJdbcBatchItemWriter<T> extends JdbcBatchItemWriter<T> {
	@Override
	public  void write(List<? extends T> items) throws Exception {
		Object[] object = items.toArray();
		Student student = (Student) object[0];
		try {
			super.write(items);
			DataHandling.succeedUpdateById(student.getId());
		} catch (DuplicateKeyException e) {
			System.out.println("主键冲突");
			DataHandling.LoseUpdateById(student.getId());
		}
	}
}
