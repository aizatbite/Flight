<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Flight Booking</title>
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
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
        }
        input, select {
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ddd;
            font-size: 16px;
        }
        button {
            cursor: pointer;
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #0056b3;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
        }
        button:hover {
            background-color: #004494;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book Your Flight</h2>
        <form action="insertbooking" method="post">
            <label for="flightId">Flight ID:</label>
            <input type="text" id="flightId" name="flightId" required>
            
            <label for="passengerId">Passenger ID:</label>
            <input type="text" id="passengerId" name="passengerId" required>
            
            <label for="paymentStatus">Payment Status:</label>
            <select id="paymentStatus" name="paymentStatus">
                <option value="PENDING">Pending</option>
                <option value="COMPLETED">Completed</option>
                <option value="FAILED">Failed</option>
            </select>
            
            <button type="submit">Submit Booking</button>
        </form>
    </div>
</body>
</html>
