<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head></head>
<body>
	<h1>Settings</h1>
	<form method="POST">
	REC: <input name="rec_color" type="color" value="${pref.recurringColor}" />
	<input name="rec_text_color" type="color" value="${pref.recurringTextColor}" /> <br>
	
	SUN <input name="sun_color" type="color" value="${pref.sundayColor}" />
	<input name="sun_text_color" type="color" value="${pref.sundayTextColor}" /> <br>
	
	MON <input name="mon_color" type="color" value="${pref.mondayColor}" />
	<input name="mon_text_color" type="color" value="${pref.mondayTextColor}" /> <br>
	
	TUE <input name="tue_color" type="color" value="${pref.tuesdayColor}" />
	<input name="tue_text_color" type="color" value="${pref.tuesdayTextColor}" /> <br>
	
	WED <input name="wed_color" type="color" value="${pref.wednesdayColor}" />
	<input name="wed_text_color" type="color" value="${pref.wednesdayTextColor}" /> <br>
	
	THU <input name="thu_color" type="color" value="${pref.thursdayColor}" />
	<input name="thu_text_color" type="color" value="${pref.thursdayTextColor}" /> <br>
	
	FRI <input name="fri_color" type="color" value="${pref.fridayColor}" />
	<input name="fri_text_color" type="color" value="${pref.fridayTextColor}" /> <br>
	
	SAT <input name="sat_color" type="color" value="${pref.saturdayColor}" />
	<input name="sat_text_color" type="color" value="${pref.saturdayTextColor}" /> <br>
	
	
	<input type="submit" value="submit" />
	</form>
	
	<h2>${success}</h2>
</body>

</html>