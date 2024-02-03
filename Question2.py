"""
    Version used : Python 3

"""




#
# Complete the 'preprocessDate' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts STRING_ARRAY dates as parameter.
#
from datetime import datetime
def preprocessDate(dates):
    processed_dates = []

    def convert_date_format(date):
        day, month, year = date.split(' ')
        day = day.rstrip("thstndrd")
        month_number = datetime.strptime(month, '%b').month
        return f"{year}-{month_number:02d}-{int(day):02d}"

    for date in dates:
        processed_dates.append(convert_date_format(date))

    return processed_dates

if __name__ == '__main__':
    dates_count = int(input().strip())

    dates = []

    for _ in range(dates_count):
        dates_item = input()
        dates.append(dates_item)

    result = preprocessDate(dates)

    # Imprime os resultados diretamente na saída padrão
    for date in result:
        print(date)