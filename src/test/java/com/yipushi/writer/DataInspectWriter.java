package com.yipushi.writer;

import java.util.List;

import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.yipushi.entity.Student;
import com.yipushi.handling.DataHandling;

/**
 * 检查数据库
 */
public class DataInspectWriter<T> extends JdbcBatchItemWriter<T> {

	@Override
	public void write(List<? extends T> items) throws Exception {
		Object[] object = items.toArray();
		Student student = (Student) object[0];
		if(student.getState() == 2){
			DataHandling.deleteById(student.getId());
			super.write(items);
			DataHandling.succeedUpdateById(student.getId());
		}
	}
}
