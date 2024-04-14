package tu.sofia.travel.model.payload;

public record ErrorResponse(
        String error,
        String message
) {}
