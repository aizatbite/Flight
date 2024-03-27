<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Booking Result</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                padding: 20px;
                background-color: #f4f4f4;
            }
            .container {
                max-width: 600px;
                margin: auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }
            .result {
                margin-top: 20px;
                padding: 10px;
                background-color: #dff0d8; /* Light green background for success message */
                color: #3c763d; /* Dark green text for contrast */
                border: 1px solid #d6e9c6; /* Slightly darker green border */
                border-radius: 4px;
                text-align: center;
            }
            .error {
                background-color: #f2dede; /* Light red background for error message */
                color: #a94442; /* Dark red text for contrast */
                border: 1px solid #ebccd1; /* Slightly darker red border */
            }
            .pay-now-btn {
                display: inline-block;
                padding: 10px 20px;
                margin-top: 20px;
                background-color: #4CAF50; /* Green */
                color: white;
                text-align: center;
                text-decoration: none;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .pay-now-btn:hover {
                background-color: #45a049;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h2>Flight Booking Result</h2>
            <div class="<%= request.getAttribute("insertSuccess") != null && (Boolean) request.getAttribute("insertSuccess") ? "result" : "result error"%>">
                <%= request.getAttribute("insertSuccess") != null && (Boolean) request.getAttribute("insertSuccess") ? "Your flight booking was successfully completed." : "There was an error processing your flight booking. Please try again."%>
            </div>
            <!-- Payment Form Button -->
            <form action="payment.jsp" method="get">
                <input type="hidden" name="bookingId" value="<%=request.getAttribute("bookingId")%>" />
                <input type="hidden" name="amount" value="100" />
                <button type="submit" class="pay-now-btn">Pay Now</button>
            </form>

        </div>
    </body>
</html>
