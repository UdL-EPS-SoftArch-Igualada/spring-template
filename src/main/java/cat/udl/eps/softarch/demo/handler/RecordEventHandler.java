package cat.udl.eps.softarch.demo.handler;

import java.time.ZonedDateTime;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import cat.udl.eps.softarch.demo.domain.Record;
import cat.udl.eps.softarch.demo.repository.RecordRepository;

@Component
@RepositoryEventHandler
public class RecordEventHandler {
	final RecordRepository recordRepository;

	public RecordEventHandler(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}

	@HandleBeforeCreate
	public void handleRecordPreCreate(Record record) {
		ZonedDateTime timeStamp = ZonedDateTime.now();
		record.setCreated(timeStamp);
		record.setModified(timeStamp);
	}

	@HandleBeforeSave
	public void handleRecordPreSave(Record record) {
		ZonedDateTime timeStamp = ZonedDateTime.now();
		record.setModified(timeStamp);
	}
}
