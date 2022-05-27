package com.hr.springintegration.config;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.AcceptOnceFileListFilter;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

/**
 * 
 * 1. All '.txt' files are read from the input directory
 * 2. Then these are written to the output directory
 * 
 * Note: Each file is processed only once.
 * 
 */
@Configuration
@EnableIntegration
public class FileAdapterConfig {

	@Bean
	@InboundChannelAdapter(value="fileInputChannel", poller = @Poller(fixedDelay = "2000"))
	public FileReadingMessageSource fileReadingMessageSource()
	{
		final FileReadingMessageSource fileReader = new FileReadingMessageSource();
		fileReader.setDirectory(new File("/Users/himanshubhusanrath/Desktop/Azure-AI"));
		
		// AcceptOnceFileListFilter ensures the file is processed only once.
		final Collection filters = Arrays.asList(new AcceptOnceFileListFilter());
		final CompositeFileListFilter<File> filter = new CompositeFileListFilter<File>(filters);
		filter.addFilter(new SimplePatternFileListFilter("*.txt"));
		
		fileReader.setFilter(filter);
		
		return fileReader;
	}
	
	@Bean
	@ServiceActivator(inputChannel = "fileInputChannel")
	public FileWritingMessageHandler fileWritingMessageHandler()
	{
		final FileWritingMessageHandler fileWriter = new FileWritingMessageHandler(new File("/Users/himanshubhusanrath/Desktop/output"));
		fileWriter.setAutoCreateDirectory(true);
		fileWriter.setExpectReply(false);
		return fileWriter;
	}
	
}
