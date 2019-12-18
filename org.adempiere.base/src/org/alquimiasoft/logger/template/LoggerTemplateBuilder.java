package org.alquimiasoft.logger.template;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class LoggerTemplateBuilder {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	private LoggerTemplateBuilder() {
		// TODO Auto-generated constructor stub
	}

	public static LoggerEventBuilderTemplate event() {
		return new LoggerEventBuilderTemplate();
	}

	public static LoggerLogicBuilderTemplate logic() {
		return new LoggerLogicBuilderTemplate();
	}

	public static LoggerDaoBuilderTemplate dao() {
		return new LoggerDaoBuilderTemplate();
	}

	public static LoggerStatementBuilderTemplate statement() {
		return new LoggerStatementBuilderTemplate();
	}
	public static LoggerProcessBuilderTemplate process() {
		return new LoggerProcessBuilderTemplate();
	}
	public static  LoggerReportBuilderTemplate html() {
		return new LoggerReportBuilderTemplate();
	}
	public static LoggerCallOutBuilderTemplate callout() {
		return new LoggerCallOutBuilderTemplate();
	}

	public static final class LoggerEventBuilderTemplate implements LoggerTemplate {

		private String clazz;
		private String process;
		private long duration;
		private int userId;
		private String action;
		private String level;
		private String message;
		private String trackId;


		private LoggerEventBuilderTemplate() {
		}

		@Override
		public String buildLoggerMessage() {
			return String.format(
					"ATIX timestamp=\"%s\" type=\"VALIDATOR\" class=\"%s\" process=\"%s\" trackId=\"%s\" duration=\"%s\" userId=\"%s\" action=\"%s\" level=\"%s\" message=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "", this.process != null ? this.process : "",
					this.trackId, this.duration, this.userId, this.action != null ? this.action : "",
					this.level != null ? this.level : "", this.message != null ? this.message : "");
		}

		public LoggerEventBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}

		public LoggerEventBuilderTemplate process(String process) {
			this.process = process;
			return this;
		}

		public LoggerEventBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}

		public LoggerEventBuilderTemplate userId(int userId) {
			this.userId = userId;
			return this;
		}

		public LoggerEventBuilderTemplate action(String action) {
			this.action = action;
			return this;
		}

		public LoggerEventBuilderTemplate message(String message) {
			this.message = message;
			return this;
		}

		@Override
		public LoggerEventBuilderTemplate level(String level) {
			this.level = level;
			return this;
		}

		public LoggerEventBuilderTemplate trackId(String trackID) {
			this.trackId = trackID;
			return this;
		}

	}

	public static final class LoggerLogicBuilderTemplate implements LoggerTemplate {

		private String level;
		private String clazz;
		private String method;
		private long duration;
		private String message;
		private String trackID;
		
		private LoggerLogicBuilderTemplate() {
		}

		@Override
		public String buildLoggerMessage() {
			return String.format("ATIX timestamp=\"%s\" type=\"SERVICE\" class=\"%s\" method=\"%s\" trackId=\"%s\" duration=\"%s\" message=\"%s\" level=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "", this.method != null ? this.method : "",
					this.trackID, this.duration, this.message != null ? this.message : "",
					this.level != null ? this.level : "");
		}

		public LoggerLogicBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}

		public LoggerLogicBuilderTemplate method(String method) {
			this.method = method;
			return this;
		}

		public LoggerLogicBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}

		public LoggerLogicBuilderTemplate message(String message) {
			this.message = message;
			return this;
		}

		public LoggerLogicBuilderTemplate trackID(String trackID) {
			this.trackID = trackID;
			return this;
		}
		@Override
		public LoggerTemplate level(String level) {
			this.level = level;
			return this;
		}

	}

	public static final class LoggerDaoBuilderTemplate implements LoggerTemplate {

		private String level;
		private String clazz;
		private String method;
		private long duration;
		private String message;
		private String trackID;
		
		private LoggerDaoBuilderTemplate() {
		}

		@Override
		public String buildLoggerMessage() {
			return String.format("ATIX timestamp=\"%s\" type=\"DAO\" class=\"%s\" method=\"%s\" trackId=\"%s\" duration=\"%s\" message=\"%s\" level=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "", this.method != null ? this.method : "",
					this.trackID, this.duration, this.message != null ? this.message : "",
					this.level != null ? this.level : "");
		}

		public LoggerDaoBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}

		public LoggerDaoBuilderTemplate method(String method) {
			this.method = method;
			return this;
		}

		public LoggerDaoBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}

		public LoggerDaoBuilderTemplate message(String message) {
			this.message = message;
			return this;
		}
		public LoggerDaoBuilderTemplate trackID(String trackID) {
			this.trackID = trackID;
			return this;
		}
		@Override
		public LoggerTemplate level(String level) {
			this.level = level;
			return this;
		}

	}

	public static final class LoggerStatementBuilderTemplate implements LoggerTemplate {

		private String level;
		private String clazz;
		private String sql;
		private long duration;
		private String trackID;
		private int userId;
		
		private LoggerStatementBuilderTemplate() {
		}

		@Override
		public String buildLoggerMessage() {
			String sql =this.sql != null ? this.sql.replace("\"", "") : "";
			sql = sql.replace("'", "");
			sql = sql.replace("\n", "");
			return String.format("ATIX timestamp=\"%s\" type=\"STATEMENT\" class=\"%s\" trackId=\"%s\" duration=\"%s\" sql=\"%s\" level=\"%s\" userId=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "",this.trackID, this.duration,
							sql, this.level != null ? this.level : "", this.userId);
		}

		public LoggerStatementBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}

		public LoggerStatementBuilderTemplate sql(String sql) {
			this.sql = sql;
			return this;
		}

		public LoggerStatementBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}
		public LoggerStatementBuilderTemplate trackID(String trackID) {
			this.trackID = trackID;
			return this;
		}
		public LoggerStatementBuilderTemplate userId(int userId) {
			this.userId = userId;
			return this;
		}
		@Override
		public LoggerTemplate level(String level) {
			this.level = level;
			return this;
		}

	}

	public static final class LoggerProcessBuilderTemplate implements LoggerTemplate {

		private String level;
		private String clazz;
		private String process;
		private String trackId;
		private long duration;
		private int userId;

		@Override
		public String buildLoggerMessage() {
			return String.format("ATIX timestamp=\"%s\" type=\"PROCESS\" class=\"%s\" trackId=\"%s\" duration=\"%s\" process=\"%s\" level=\"%s\" userId=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "", trackId, this.duration,
					this.process != null ? this.process : "", this.level != null ? this.level : "", userId);
		}

		public LoggerProcessBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}
		public LoggerProcessBuilderTemplate process(String process) {
			this.process = process;
			return this;
		}
		public LoggerProcessBuilderTemplate trackId(String trackId) {
			this.trackId = trackId;
			return this;
		}
		public LoggerProcessBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}
		public LoggerProcessBuilderTemplate userId(int userId) {
			this.userId = userId;
			return this;
		}

		@Override
		public LoggerProcessBuilderTemplate level(String level) {
			this.level = level;
			return this;
		}

	}
	public static final class LoggerReportBuilderTemplate implements LoggerTemplate{

		private String level;
		private int processID;
		private int pinstanceID;
		private int userId;
		private long duration;
		private String trackId;
		private String view;
		private LoggerReportBuilderTemplate() {}
		
		@Override
		public String buildLoggerMessage() {
			return String.format("ATIX timestamp=\"%s\" type=\"REPORT\" class=\"%s\" trackId=\"%s\" duration=\"%s\" level=\"%s\" processID=\"%s\" pinstanceID=\"%s\" userId=\"%s\" view=\"%s\" ", 
					DATE_FORMAT.format(new Date()),
					"",
					this.trackId,
					this.duration,
					this.level != null ? this.level : "",
					this.processID,
					this.pinstanceID,
					this.userId,
					this.view);
		}
		@Override
		public LoggerReportBuilderTemplate level(String level) {
			this.level = level;
			return this;
		}
		
		public LoggerReportBuilderTemplate processID(int processID) {
			this.processID = processID;
			return this;
		}
		public LoggerReportBuilderTemplate pinstanceID(int pinstanceID) {
			this.pinstanceID = pinstanceID;
			return this;
		}
		public LoggerReportBuilderTemplate userID(int userId) {
			this.userId = userId;
			return this;
		}
		public LoggerReportBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}
		public LoggerReportBuilderTemplate trackID(String trackId) {
			this.trackId = trackId;
			return this;
		}

		public LoggerReportBuilderTemplate view(String view) {
			this.view = view;
			return this;
		}
		
	}
	
	public static final class LoggerCallOutBuilderTemplate implements LoggerTemplate {

		private String clazz;
		private long duration;
		private int userId;
		private String level;
		private String message;
		private String trackId;
		private int table;
		private int column;

		private LoggerCallOutBuilderTemplate() {
		}

		@Override
		public String buildLoggerMessage() {
			return String.format(
					"ATIX timestamp=\"%s\" type=\"CALLOUT\" class=\"%s\" trackId=\"%s\" duration=\"%s\" userId=\"%s\" table=\"%s\" column=\"%s\" level=\"%s\" message=\"%s\"",
					DATE_FORMAT.format(new Date()),
					this.clazz != null ? this.clazz : "",
					this.trackId,
					this.duration,
					this.userId, 
					this.table,
					this.column,
					this.level != null ? this.level : "",
					this.message != null ? this.message : "");
		}

		public LoggerCallOutBuilderTemplate clazz(String clazz) {
			this.clazz = clazz;
			return this;
		}

		public LoggerCallOutBuilderTemplate duration(long duration) {
			this.duration = duration;
			return this;
		}

		public LoggerCallOutBuilderTemplate userId(int userId) {
			this.userId = userId;
			return this;
		}

		public LoggerCallOutBuilderTemplate message(String message) {
			this.message = message;
			return this;
		}

		@Override
		public LoggerCallOutBuilderTemplate level(String level) {
			this.level = level;
			return this;
		}

		public LoggerCallOutBuilderTemplate trackId(String trackID) {
			this.trackId = trackID;
			return this;
		}

		public LoggerCallOutBuilderTemplate table(int table) {
			this.table = table;
			return this;
		}
		public LoggerCallOutBuilderTemplate column(int column) {
			this.column = column;
			return this;
		}
	}
	
}
