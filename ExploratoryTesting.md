# Monefy Exploratory testing charters
- App : [Monefy](https://play.google.com/store/apps/details?id=com.monefy.app.lite) Freemium Version
- App Version : 1.16.0
- Environment - Production
- Platform - Android
- Android Version - 12
- Resolution - 1080 x 2400

## Tests

- Explore enter expenses from a category dated after the current date to discover enter expenses from a category
- Explore expense from the button with negative expense value to discover if the app allows saving it
- Explore Expense with an expense from a category, note and valid values to discover if the expense is shown in the main graph
- Explore the Expense button with all categories with and without notes to discover if all categories are working as expected
- Explore Expense with a different account to discover if the expense is saved in the selected account
- Explore Expense with dated before the current date to discover if the app allows saving it
- Explore Expense with the note field empty to discover if the app allows saving it
- Explore Edit expense with different values to discover if changes were saved
- Explore delete an expense with previously saved records to discover if the expense was eliminated
- Explore Balances Graph with Different expenses and incomes to discover if changes were saved
- Explore Balances Graph with different expenses in multiple accounts to discover if the account balance is calculated correctly
- Explore Balances Graph with different expenses in multiple accounts to discover how the expense details are showed
- Explore Balance Incomes with different Incomes in multiple accounts to discover how shows the percentage of expenses by category
- Explore Balance Incomes with different Incomes in multiple accounts to discover how income is reflected in the balance sheet chart
- Explore Balance Incomes with different Incomes category to discover how income is reflected in the balance sheet chart
- Explore Budget mode with a definite budget, different incomes and expenses to discover how works the budget mode
- Explore Modify Budget mode with different budget values to discover bugs in budget mode
- Explore Modify Budget mode with different flows to fill budget values to discover bugs in budget mode
- Explore Budget mode with different currencies and amounts to discover errors in the budget mode
- Explore data Backup with backup name empty to discover errors in the data backup functionality
- Explore restorer data Backup with a previous data backup created to discover if the restorer data backup functionality works correctly
- Explore erase data with incomes and expenses movements to discover if the eraser data feature works
- Explore account creation with the same data (name, icon, initial account credit) to discover what is the restriction to creating accounts with the same configuration
- Explore account creation with initial account credit greater than 15 digits to discover if it allows creating it
- Explore editing an account with different values to discover bugs in editing the account
- Explore deleting an account with balance movement to discover if it allows it
- Explore Transfers with large amounts of money from account A to account A to discover bugs in transfer
- Explore Transfers with different flows to discover bugs in transfer functionality
- Explore deleting a transfer with an account with a negative balance to discover how it works
- Explore Settings with to Unlock Monefy Pro option to discover if the Monefy Pro ad is shown
- Explore Settings with Dark theme enabled to discover if the Monefy Pro ad is shown
- Explore Settings with different languages to discover if the app is shown in the selected language
- Explore Settings with different currencies to discover if all records are shown in the selected currency
- Explore Settings with Passcode to discover if the Monefy Pro ad is shown
- Explore Settings with the review application to discover if the store is open
- Explore Settings with about Monefy to discover if an About popup is shown
- Explore Settings with the privacy policy to discover if the user is redirected to the privacy policy web page
- Explore Settings by creating a backup to discover if a backup is saved in the Monefy cloud
- Explore Settings with restore backups to discover if a backup is restored correctly
- Explore Settings with a clear date to discover if all records are deleted
- Explore Export to file by checking file content on Excel to discover if data is stored correctly

## Risks
- Loss of data
- Security

## Bugs
1. Language change doesn't work, If change the language to Deutsch, still I see almost all the text and buttons in English
2. After changing the language to Deutsch and When I closed the app and opened the Expense & Income buttons disappeared (replaced with - & +)
3. Since I use the Freemium  version, If I delete a category by mistake, I cannot add it back (The validation Message is not clear,
   While deleting the category nowhere does it mention that I can not add the category again)
4. Changing currency doesn't convert reported records value from the previous to the new currency. It just replaces the currency symbol (Ex: $ with €)