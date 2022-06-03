package edu.upc.eetac.dsa.services;

import edu.upc.eetac.dsa.dao.QuestionDAO;
import edu.upc.eetac.dsa.dao.impl.QuestionDAOImpl;
import edu.upc.eetac.dsa.models.Question;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/question", description = "Endpoint to Question Service")
@Path("/question")
public class QuestionService {

    private QuestionDAO manager;

    public QuestionService() {
        this.manager = QuestionDAOImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "questions asked", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response= Question.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/askQuestion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addQuestion(Question q) {

        Question question = new Question(q.getDate(), q.getTitle(), q.getMessage(), q.getSender());
        if (question.getDate().isEmpty() || question.getTitle().isEmpty() || question.getMessage().isEmpty() || question.getSender().isEmpty())
            return Response.status(500).entity(question).build();

        else {
            this.manager.addQuestion(question);
            return Response.status(200).entity(question).build();
        }
    }
}
