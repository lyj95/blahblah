<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href='resources/calendar/packages/core/main.css' rel='stylesheet' />
<link href='resources/calendar/packages/daygrid/main.css' rel='stylesheet' />
<script src='resources/calendar/packages/core/main.js'></script>
<script src='resources/calendar/packages/interaction/main.js'></script>
<script src='resources/calendar/packages/daygrid/main.js'></script>
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var d = new Date();

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid' ],
      defaultDate: d,
      editable: false,
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: 'All Day Event',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-01'
        },
        {
          title: 'Long Event',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-07',
          end: '2019-08-10'
        },
        {
          groupId: 999,
          title: 'Repeating Event',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-09T16:00:00'
        },
        {
          groupId: 999,
          title: 'Repeating Event',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-16T16:00:00'
        },
        {
          title: 'Conference',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-11',
          end: '2019-08-13'
        },
        {
          title: 'Meeting',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-12T10:30:00',
          end: '2019-08-12T12:30:00'
        },
        {
          title: 'Lunch',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-12T12:00:00'
        },
        {
          title: 'Meeting',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-12T17:30:00'
        },
        {
          title: 'Dinner',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-12T20:00:00'
        },
        {
          title: 'Birthday Party',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-13T07:00:00'
        },
        {
          title: 'Click for Google',
          url: 'none',     //강의실 링크 넣기
          start: '2019-08-28'
        }
      ]
    });

    calendar.render();
  });

</script>

<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }

</style>

</head>


<body>

  <div id='calendar'></div>

</body>
</html>
