'''
Gets a year, month and day of month from the user then
outputs the number of days elapsed so far in the given year (inclusive)
and the number of days total that have elapsed since that date

Prints the results to the console
'''

import datetime as dt

# Initialises todays date as 3 separate variables (Excludes current time)
def todays_date():
    global day_today
    global month_today
    global year_today
    day_today   = int(dt.datetime.today().strftime("%d"))
    month_today = int(dt.datetime.today().strftime("%m"))
    year_today  = int(dt.datetime.today().strftime("%Y"))
    return


todays_date()
month_length = [31,28,31,30,31,30,31,31,30,31,30,31]

# Returns True if a year is leap, False if not
def is_year_leap(year):
    if year % 4 != 0:
        return False
    elif year % 100 != 0:
        return True
    elif year % 400 != 0:
        return False
    else:
        return True


# Returns the number of days in a given month
def days_in_month(year, month):   
    if not is_year_leap(year):
        return month_length[month - 1]
    elif is_year_leap:
        month_length[1] = 29
        return month_length[month - 1]
    else:
        return None


# Returns the day of the year
def day_of_year(year, month, day):
    day_number = 0
    month_list = month_length[:month - 1]
    if not is_year_leap(year):
        for count in month_list:
            day_number += count
        return day_number + day
    elif is_year_leap(year):
        for count in month_list:
            day_number += count
        return day_number + day  + 1
    else:
        return None


# Converts a month number into the respective month name
def month_name(mo):
    month_names = ["January", "February", "March", "April",
                   "May", "June", "July", "August",
                   "September", "October", "November", "December"]
    return month_names[mo - 1] # Subtracts 1 to adhere to list indexing


# Checks user input for the month value
def month_tested(val):
    month_tested = 'fail'
    if val == "1" or val == "01" or\
       val == "january" or val == "jan" or\
       val == "January" or val == "Jan":
        month_tested = 1
    elif val == "2" or val == "02" or\
         val == "february" or val == "feb" or\
         val == "February" or val == "Feb":
        month_tested = 2
    elif val == "3" or val == "03" or\
         val == "march" or val == "mar" or\
         val == "March" or val == "Mar":
        month_tested = 3
    elif val == "4" or val == "04" or\
         val == "april" or val == "apr" or\
         val == "April" or val == "Apr":
        month_tested = 4
    elif val == "5" or val == "05" or\
         val == "may" or val == "May":
        month_tested = 5
    elif val == "6" or val == "06" or\
         val == "june" or val == "jun" or\
         val == "June" or val == "Jun":
        month_tested = 6
    elif val == "7" or val == "07" or\
         val == "july" or val == "jul" or\
         val == "July" or val == "Jul":
        month_tested = 7
    elif val == "8" or val == "08" or\
         val == "august" or val == "aug" or\
         val == "August" or val == "Aug":
        month_tested = 8
    elif val == "9" or val == "09" or\
         val == "september" or val == "sep" or\
         val == "September" or val == "Sep":
        month_tested = 9
    elif val == "10" or\
         val == "october" or val == "oct" or\
         val == "October" or val == "Oct":
        month_tested = 10
    elif val == "11" or\
         val == "november" or val == "nov" or\
         val == "November" or val == "Nov":
        month_tested = 11
    elif val == "12" or\
         val == "december" or val == "dec" or\
         val == "December" or val == "Dec":
        month_tested = 12
    return month_tested


# Checks user input for day
def day_tested(day_number):
    day_pass = False
    while day_pass == False:
        if is_year_leap(yr):
            month_length[1] = 29

        if day_number < 0 or day_number > (month_length[mo - 1]):
            return False
        else:
            day_pass = True
            break
    return True


# Gets user input for year, month, day
def gather_input():

    year_pass = False
    month_pass = False
    day_pass = False
    global yr
    global mo
    global dy
    while year_pass == False:
        yr = int(input("Enter a year.. "))
        if yr < -9999999999 or yr > 9999999999:
            print("Not a valid year number..")
            continue
        else:
            year_pass = True
            break

    while month_pass == False:
        mo = month_tested(input("Enter a month.. "))
        if mo == 'fail':
            continue
        elif mo > 0 or mo < 13:
            month_pass = True
            break
        else:
            continue

    while day_pass == False:
        dy = int(input("Enter a day.. "))
        if day_tested(dy) == True:
            day_pass = True
            break
        else:
            continue


# Returns the number of days in a year depending on whether the year is leap
def count_days(year):
    global days_in_year
    leap_check = is_year_leap(year)
    if leap_check == True:
        days_in_year = 366
    elif leap_check == False:
        days_in_year = 365
    return days_in_year


gather_input()

# Outputs the number of days that have elapsed since the start of the given year
print("\n", dy, " ", month_name(mo), " is day ", day_of_year(yr, mo, dy), " of ", yr,"\n", sep="")

# Counts the days that have elapsed since the given date
num_of_years = year_today - yr
days_since = count_days(yr) - day_of_year(yr, mo, dy)
current_year=yr+1

for count in range(num_of_years - 1):
    days_since += count_days(current_year)
    current_year +=1

days_since = days_since + day_of_year(year_today,month_today,day_today)

# Outputs the number of days that have elapsed since the given date
print("It has been ",days_since," days since ",dy," ",month_name(mo)," ",yr,".\n", sep="")

    
