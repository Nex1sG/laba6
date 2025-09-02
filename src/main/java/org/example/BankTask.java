public void transferMoney(Account from, Account to, int amount) {
    // Проверки
    if (from == null || to == null) throw new IllegalArgumentException("Счёт не может быть null");
    if (amount <= 0) throw new IllegalArgumentException("Сумма должна быть > 0");
    if (from == to) throw new IllegalArgumentException("Нельзя переводить самому себе");

    // Упорядочиваем блокировки по id
    Account first = from.getId() < to.getId() ? from : to;
    Account second = from.getId() < to.getId() ? to : from;

    synchronized (first) {
        synchronized (second) {
            if (from.getBalance() >= amount) {
                from.withdraw(amount);
                to.deposit(amount);
            } else {
                throw new IllegalStateException("Недостаточно средств");
            }
        }
    }
}