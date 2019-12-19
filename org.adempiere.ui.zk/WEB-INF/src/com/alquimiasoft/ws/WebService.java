package com.alquimiasoft.ws;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.adempiere.rest.service.RestService;
import org.adempiere.rest.service.ServiceNotFoundException;
import org.compiere.model.MInvoice;
import org.compiere.util.Env;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.alquimiasoft.dto.InvoiceDTO;
import com.google.gson.Gson;

@Path("/")
public class WebService {

	private Gson gson = new Gson();

	@POST
	@Produces({ "application/json" })
	@Path("/getMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response mostrarMensaje(String jsonInvoice) {
		String output = "Success";
		try {
			Gson gson = new Gson();
			InvoiceDTO dto = gson.fromJson(jsonInvoice, InvoiceDTO.class);
			MInvoice i = new MInvoice(Env.getCtx(), dto.getC_invoice_id(), null);
			i.setDescription(i.getDescription() + dto.getDescription());
			i.saveEx();
		} catch (Exception e) {
			output = e.getMessage();
		}
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/getData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getData(@QueryParam("content") String content, @QueryParam("action") String action,
			@QueryParam("method") String method) {

		BundleContext ctx = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		if (ctx != null) {
			ServiceReference<RestService> serviceref = ctx.getServiceReference(RestService.class);
			if (serviceref != null) {
				RestService restService = ctx.getService(serviceref);
				try {
					if (action == null || action.isEmpty()) {
						return Response.status(Status.PRECONDITION_FAILED)
								.entity(gson.toJson("No ha especificado una acci�n")).build();
					} else if (content == null || content.isEmpty()) {
						return Response.status(Status.PRECONDITION_FAILED)
								.entity(gson.toJson("No ha especificado un valor para la acci�n")).build();
					}
					Object response = restService.getData(action, UUID.randomUUID(), content, method);
					return Response.ok(gson.toJson(response)).build();
				} catch (ValidationException validationException) {
					Map<String, Object> validationResponse = new HashMap<String, Object>();
					validationResponse.put("exceptionMessage", validationException.getMessage());
					return Response.status(Status.PRECONDITION_FAILED).entity(gson.toJson(validationResponse)).build();
				} catch (ServiceNotFoundException exception) {
					Map<String, Object> exceptionResponse = new HashMap<String, Object>();
					exceptionResponse.put("message", exception.getMessage());
					return Response.status(Status.NOT_FOUND).entity(gson.toJson(exceptionResponse)).build();
				} catch (Exception exception) {
					Map<String, Object> exceptionResponse = new HashMap<String, Object>();
					exceptionResponse.put("type", exception.getClass().getName());
					exceptionResponse.put("exceptionMessage", exception.getMessage());
					exceptionResponse.put("stackTrace", this.getStackTrace(exception));
					return Response.status(Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(exceptionResponse)).build();
				}
			}
		}
		return Response.status(Status.NOT_MODIFIED).entity("No hay implementacion").build();
	}

	@POST
	@Path("/doService/{action}/{method}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doService(String content, @PathParam("action") String action, @PathParam("method") String method) {

		BundleContext ctx = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		if (ctx != null) {
			ServiceReference<RestService> serviceref = ctx.getServiceReference(RestService.class);
			if (serviceref != null) {
				RestService restService = ctx.getService(serviceref);
				try {
					if (action == null || action.isEmpty()) {
						return Response.status(Status.PRECONDITION_FAILED)
								.entity(gson.toJson("No ha especificado una acci�n")).build();
					} else if (content == null || content.isEmpty()) {
						return Response.status(Status.PRECONDITION_FAILED)
								.entity(gson.toJson("No ha especificado un valor para la acci�n")).build();
					}
					Object response = restService.doService(action, UUID.randomUUID(), content, method);
					return Response.ok(gson.toJson(response)).build();
				} catch (ValidationException validationException) {
					Map<String, Object> validationResponse = new HashMap<String, Object>();
					validationResponse.put("exceptionMessage", validationException.getMessage());
					return Response.status(Status.PRECONDITION_FAILED).entity(gson.toJson(validationResponse)).build();
				} catch (ServiceNotFoundException exception) {
					Map<String, Object> exceptionResponse = new HashMap<String, Object>();
					exceptionResponse.put("message", exception.getMessage());
					return Response.status(Status.NOT_FOUND).entity(gson.toJson(exceptionResponse)).build();
				} catch (Exception exception) {
					Map<String, Object> exceptionResponse = new HashMap<String, Object>();
					exceptionResponse.put("type", exception.getClass().getName());
					exceptionResponse.put("exceptionMessage", exception.getMessage());
					exceptionResponse.put("stackTrace", this.getStackTrace(exception));
					return Response.status(Status.INTERNAL_SERVER_ERROR).entity(gson.toJson(exceptionResponse)).build();
				}
			}
		}
		return Response.status(Status.NOT_MODIFIED).entity("No hay implementacion").build();
	}

	private String getStackTrace(Throwable throwable) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		return sw.toString();
	}

}
